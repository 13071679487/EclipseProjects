package com.rifu.lucence;

import java.nio.file.Paths;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.Term;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.junit.Before;
import org.junit.Test;

public class IndexingTest {
	private String ids[]={"1","2","3"};
	private String citys[]={"qingdao","nanjing","shanghai"};
	private String descs[]={
			"Qingdao is a beautiful city.",
			"Nanjing is a city of culture.",
			"Shanghai is a bustling city."
	};
	
	private Directory dir;
	
	
	
	@Before
	public void setUp() throws Exception {
		
	}
	
	/**
	 * ���������������������ĳ�ʼ��
	 * @throws Exception
	 */
	@Test
	public void buildIndex()throws Exception{
		dir=FSDirectory.open(Paths.get("D:\\lucene"));
		IndexWriter writer=getWriter();
		for(int i=0;i<ids.length;i++){
			Document doc=new Document();
			doc.add(new StringField("id", ids[i], Field.Store.YES));
			doc.add(new StringField("city",citys[i],Field.Store.YES));
			doc.add(new TextField("desc", descs[i], Field.Store.NO));
			writer.addDocument(doc); // ����ĵ�
		}
		writer.close();
	}

	/**
	 * ��ȡIndexWriterʵ��
	 * @return
	 * @throws Exception
	 */
	private IndexWriter getWriter()throws Exception{
		Analyzer analyzer=new StandardAnalyzer(); // ��׼�ִ���
		IndexWriterConfig iwc=new IndexWriterConfig(analyzer);
		IndexWriter writer=new IndexWriter(dir, iwc);
		return writer;
	}
	
	/**
	 * ����д�˼����ĵ�
	 * @throws Exception
	 */
	@Test
	public void testIndexWriter()throws Exception{
		IndexWriter writer=getWriter();
		System.out.println("д����"+writer.numDocs()+"���ĵ�");
		writer.close();
	}
	
	/**
	 * ���Զ�ȡ�ĵ�
	 * @throws Exception
	 */
	@Test
	public void testIndexReader()throws Exception{
		IndexReader reader=DirectoryReader.open(dir);
		System.out.println("����ĵ�����"+reader.maxDoc());
		System.out.println("ʵ���ĵ�����"+reader.numDocs());
		reader.close();
	}
	
	@Test
	public void testSearch()throws Exception{
		String indexDir="D:\\lucene";
		String q="beautiful";
		search(indexDir,q);
	}
	
	public static void search(String indexDir,String q)throws Exception{
		Directory dir=FSDirectory.open(Paths.get(indexDir));
		IndexReader reader=DirectoryReader.open(dir);
		IndexSearcher is=new IndexSearcher(reader);
		Analyzer analyzer=new StandardAnalyzer(); // ��׼�ִ���
		QueryParser parser=new QueryParser("desc", analyzer);
		Query query=parser.parse(q);
		long start=System.currentTimeMillis();
		TopDocs hits=is.search(query, 10);
		long end=System.currentTimeMillis();
		System.out.println("ƥ�� "+q+" ���ܹ�����"+(end-start)+"����"+"��ѯ��"+hits.totalHits+"����¼");
		for(ScoreDoc scoreDoc:hits.scoreDocs){
			Document doc=is.doc(scoreDoc.doc);
			System.out.println(doc.get("city"));
		}
		reader.close();
	}
	
	/**
	 * ����ɾ�� �ںϲ�ǰ
	 * @throws Exception
	 */
	@Test
	public void testDeleteBeforeMerge()throws Exception{
		IndexWriter writer=getWriter();
		System.out.println("ɾ��ǰ��"+writer.numDocs());
		writer.deleteDocuments(new Term("id","1"));
		writer.commit();
		System.out.println("writer.maxDoc()��"+writer.maxDoc());
		System.out.println("writer.numDocs()��"+writer.numDocs());
		writer.close();
	}
	
	/**
	 * ����ɾ�� �ںϲ���
	 * @throws Exception
	 */
	@Test
	public void testDeleteAfterMerge()throws Exception{
		IndexWriter writer=getWriter();
		System.out.println("ɾ��ǰ��"+writer.numDocs());
		writer.deleteDocuments(new Term("id","1"));
		writer.forceMergeDeletes(); // ǿ��ɾ��
		writer.commit();
		System.out.println("writer.maxDoc()��"+writer.maxDoc());
		System.out.println("writer.numDocs()��"+writer.numDocs());
		writer.close();
	}

	/**
	 * ���Ը���
	 * @throws Exception
	 */
	@Test
	public void testUpdate()throws Exception{
		IndexWriter writer=getWriter();
		Document doc=new Document();
		doc.add(new StringField("id", "1", Field.Store.YES));
		doc.add(new StringField("city","qingdao",Field.Store.YES));
		doc.add(new TextField("desc", "dsss is a city.", Field.Store.NO));
		writer.updateDocument(new Term("id","1"), doc);
		writer.close();
	}
}
