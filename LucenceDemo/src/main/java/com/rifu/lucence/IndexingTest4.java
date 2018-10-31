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
 * ��Ӷ����ĵķִʣ��ͼ���
 * @author Lifu
 *
 */
public class IndexingTest4 {
	private Integer ids[]={1,2,3,4};
	private String authors[]={"��","��","��","����"};
	private String positions[]={"accounting","technician","salesperson","boss"};
	private String titles[]={"������","������","������","�����"};
	private String contents[]={
			"����ио��������ĳ��У���ï������",
			"����������˽�",
			"�ȽϺõģ��ӽ�ï����",
			"ûȥ����Ҳ��֪��"
	};
	
	private Directory dir;
	
	/**
	 * ��ȡIndexWriterʵ��
	 * @return
	 * @throws Exception
	 */
	private IndexWriter getWriter()throws Exception{
		//Analyzer analyzer=new StandardAnalyzer(); // ��׼�ִ���
		SmartChineseAnalyzer analyzer = new SmartChineseAnalyzer();	//ʹ�����ĵķִ���
		IndexWriterConfig iwc=new IndexWriterConfig(analyzer);
		IndexWriter writer=new IndexWriter(dir, iwc);
		return writer;
	}
	
	/**
	 * ��������,�����ü�Ȩ����
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
			// ��Ȩ����
			TextField field=new TextField("title", titles[i], Field.Store.YES);
			if("boss".equals(positions[i])){
				//field.setBoost(1.5f);
			}
			doc.add(field);
			doc.add(new TextField("content", contents[i], Field.Store.YES));
			writer.addDocument(doc); // ����ĵ�
		}
		writer.close();
	}

	
	/**
	 * ʹ�����ķִʽ��������в�ѯ
	 * @throws Exception
	 */
	@Test
	public void searchByMix()throws Exception{
		dir=FSDirectory.open(Paths.get("D:/Lucene/lucene3"));
		IndexReader reader=DirectoryReader.open(dir);
		IndexSearcher is=new IndexSearcher(reader);
		SmartChineseAnalyzer analyzer = new SmartChineseAnalyzer();
		QueryParser queryParser = new QueryParser("content",analyzer);
		Query query = queryParser.parse("ï��");
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
