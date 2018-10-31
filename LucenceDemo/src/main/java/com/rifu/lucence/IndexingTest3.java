package com.rifu.lucence;


import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.junit.Test;

public class IndexingTest3 {
	private Integer ids[]={1,2,3,4};
	private String authors[]={"Jack","Marry","John","Json"};
	private String positions[]={"accounting","technician","salesperson","boss"};
	private String titles[]={"Java is a good language.","Java is a cross platform language","Java powerful","You should learn java"};
	private String contents[]={
			"If possible, use the same JRE major version at both index and search time.",
			"When upgrading to a different JRE major version, consider re-indexing. ",
			"Different JRE major versions may implement different versions of Unicode,",
			"For example: with Java 1.4, `LetterTokenizer` will split around the character U+02C6,"
	};
	
	private Directory dir;
	
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
	 * ��������,�����ü�Ȩ����
	 * @throws Exception
	 */
	@Test
	public void buildIndex()throws Exception{
		/*
		dir=FSDirectory.open(Paths.get("D:/Lucene/lucene2"));
		IndexWriter writer=getWriter();
		for(int i=0;i<ids.length;i++){
			Document doc=new Document();
			doc.add(new IntField("id", ids[i], Field.Store.YES));
			doc.add(new StringField("author",authors[i],Field.Store.YES));
			doc.add(new StringField("position",positions[i],Field.Store.YES));
			// ��Ȩ����
			TextField field=new TextField("title", titles[i], Field.Store.YES);
			if("boss".equals(positions[i])){
				field.setBoost(1.5f);
			}
			doc.add(field);
			doc.add(new TextField("content", contents[i], Field.Store.NO));
			writer.addDocument(doc); // ����ĵ�
		}
		writer.close();
		*/
	}

	/**
	 * ָ����ֵ��Χ���в�ѯ(ʱ��Ҳ��һ����ֵ)
	 * @throws Exception
	 */
	@Test
	public void searchByNumericRange()throws Exception{
		/*dir=FSDirectory.open(Paths.get("D:/Lucene/lucene2"));
		IndexReader reader=DirectoryReader.open(dir);
		IndexSearcher is=new IndexSearcher(reader);
		NumericRangeQuery<Integer> query = NumericRangeQuery.newIntRange("id", 1, 3, true, true);
		TopDocs hits=is.search(query, 10);
		for(ScoreDoc scoreDoc:hits.scoreDocs){
			Document doc=is.doc(scoreDoc.doc);
			System.out.println(doc.get("author"));
		}
		reader.close();*/
	}
	
	/**
	 * ��϶�������ѯ
	 * @throws Exception
	 */
	@Test
	public void searchByMix()throws Exception{
		/*dir=FSDirectory.open(Paths.get("D:/Lucene/lucene2"));
		IndexReader reader=DirectoryReader.open(dir);
		IndexSearcher is=new IndexSearcher(reader);
		
		//1.������ֵ��Χ��ѯ
		NumericRangeQuery<Integer> query = NumericRangeQuery.newIntRange("id", 1, 3, true, true);
		//2.����ǰ׺ƥ���ѯ
		PrefixQuery prefixQuery=new PrefixQuery(new Term("content","when"));
		BooleanQuery.Builder mixQueryBuilder = new BooleanQuery.Builder();
		*//**
		 * BooleanClause.Occur.MUST==and;�����������
		 * BooleanClause.Occur.SHOULD==or;
		 *//*
		mixQueryBuilder.add(query,BooleanClause.Occur.MUST);
		mixQueryBuilder.add(prefixQuery,BooleanClause.Occur.MUST);
		
		TopDocs hits=is.search(mixQueryBuilder.build(), 10);
		for(ScoreDoc scoreDoc:hits.scoreDocs){
			Document doc=is.doc(scoreDoc.doc);
			System.out.println(doc.get("author"));
		}
		reader.close();*/
	}
}
