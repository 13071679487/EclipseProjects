package com.rifu.lucence;

import java.io.StringReader;
import java.nio.file.Paths;

import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.cn.smart.SmartChineseAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.search.highlight.Fragmenter;
import org.apache.lucene.search.highlight.Highlighter;
import org.apache.lucene.search.highlight.QueryScorer;
import org.apache.lucene.search.highlight.SimpleHTMLFormatter;
import org.apache.lucene.search.highlight.SimpleSpanFragmenter;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.junit.Test;
/**
 * 添加对中文的分词，和检索
 * @author Lifu
 *
 */
public class IndexingTest4 {
	private Integer ids[]={1,2,3,4};
	private String authors[]={"黄","理","富","厉害"};
	private String positions[]={"accounting","technician","salesperson","boss"};
	private String titles[]={"化州市","信宜市","高州市","电白市"};
	private String contents[]={
			"这个市感觉是最落后的城市，在茂名里面",
			"不清楚，不了解",
			"比较好的，接近茂名市",
			"没去过，也不知道"
	};
	
	private Directory dir;
	
	/**
	 * 获取IndexWriter实例
	 * @return
	 * @throws Exception
	 */
	private IndexWriter getWriter()throws Exception{
		//Analyzer analyzer=new StandardAnalyzer(); // 标准分词器
		SmartChineseAnalyzer analyzer = new SmartChineseAnalyzer();	//使用中文的分词器
		IndexWriterConfig iwc=new IndexWriterConfig(analyzer);
		IndexWriter writer=new IndexWriter(dir, iwc);
		return writer;
	}
	
	/**
	 * 生成索引,并设置加权规则
	 * @throws Exception
	 */
	@Test
	public void buildIndex()throws Exception{
		dir=FSDirectory.open(Paths.get("D:/Lucene/lucene3"));
		IndexWriter writer=getWriter();
		for(int i=0;i<ids.length;i++){
			Document doc=new Document();
			doc.add(new StringField("id", ids[i]+"", Field.Store.YES));
			doc.add(new StringField("author",authors[i],Field.Store.YES));
			doc.add(new StringField("position",positions[i],Field.Store.YES));
			// 加权操作
			TextField field=new TextField("title", titles[i], Field.Store.YES);
			if("boss".equals(positions[i])){
				//field.setBoost(1.5f);
			}
			doc.add(field);
			doc.add(new TextField("content", contents[i], Field.Store.YES));
			writer.addDocument(doc); // 添加文档
		}
		writer.close();
	}

	
	/**
	 * 使用中文分词解析器进行查询
	 * @throws Exception
	 */
	@Test
	public void searchByMix()throws Exception{
		dir=FSDirectory.open(Paths.get("D:/Lucene/lucene3"));
		IndexReader reader=DirectoryReader.open(dir);
		IndexSearcher is=new IndexSearcher(reader);
		SmartChineseAnalyzer analyzer = new SmartChineseAnalyzer();
		QueryParser queryParser = new QueryParser("content",analyzer);
		Query query = queryParser.parse("茂名");
		TopDocs hits=is.search(query, 10);
		
		QueryScorer scorer=new QueryScorer(query);
		Fragmenter fragmenter=new SimpleSpanFragmenter(scorer);
		SimpleHTMLFormatter simpleHTMLFormatter=new SimpleHTMLFormatter("<b><font color='red'>","</font></b>");
		Highlighter highlighter=new Highlighter(simpleHTMLFormatter, scorer);
		highlighter.setTextFragmenter(fragmenter);
		
		for(ScoreDoc scoreDoc:hits.scoreDocs){
			Document doc=is.doc(scoreDoc.doc);
			System.out.println(doc.get("author"));
			String content = doc.get("content");
			System.out.println(content);
			if(content!=null){
				TokenStream tokenStream=analyzer.tokenStream("content", new StringReader(content));
				System.out.println(highlighter.getBestFragment(tokenStream, content));
			}
		}
		reader.close();
	}
}
