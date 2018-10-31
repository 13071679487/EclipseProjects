package com.rifu.chart;

import java.awt.Color;
import java.awt.Font;

import javax.servlet.http.HttpSession;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.servlet.ServletUtilities;
import org.jfree.chart.ui.TextAnchor;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DatasetUtils;

/**
 * ����ͼ
 * @author Lifu
 *
 */
public class ChartBar {
	public static  String genBarChart(HttpSession session) throws Exception {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		dataset.addValue(510, "����", "ƻ��");
		dataset.addValue(320, "����", "�㽶");
		dataset.addValue(580, "����", "����");
		dataset.addValue(390, "����", "����");
		StandardChartTheme standardChartTheme = new StandardChartTheme("CN");
        standardChartTheme.setExtraLargeFont(new Font("����", Font.BOLD, 20));
        standardChartTheme.setRegularFont(new Font("����", Font.PLAIN, 15));
        standardChartTheme.setLargeFont(new Font("����", Font.PLAIN, 15));
        ChartFactory.setChartTheme(standardChartTheme);
		JFreeChart chart=ChartFactory.createBarChart("ˮ������ͳ��ͼ", "ˮ��", "����", dataset,
				PlotOrientation.VERTICAL, true, true, true);
		String fileName=ServletUtilities.saveChartAsPNG(chart, 700, 500, null,session);
		return fileName;
	}
	
	public static  String genCategoryBarChart(HttpSession session) throws Exception {
		double [][]data=new double[][]{{550},{660},{770},{880}};
		String [] rowKeys={"ƻ��","Banana","Orange","PineApple"};
		String [] columnKeys={"����"};
		CategoryDataset dataset = DatasetUtils.createCategoryDataset(rowKeys, columnKeys, data);
		//���������������
		StandardChartTheme standardChartTheme = new StandardChartTheme("CN");
        standardChartTheme.setExtraLargeFont(new Font("����", Font.BOLD, 20));
        standardChartTheme.setRegularFont(new Font("����", Font.PLAIN, 15));
        standardChartTheme.setLargeFont(new Font("����", Font.PLAIN, 15));
        ChartFactory.setChartTheme(standardChartTheme);
        
		JFreeChart chart=ChartFactory.createBarChart("ˮ������ͳ��ͼ", "ˮ��", "����", dataset,
				PlotOrientation.VERTICAL, true, true, true);
		String fileName=ServletUtilities.saveChartAsPNG(chart, 700, 500, null,session);
		return fileName;
	}
	
	
	public static  String genFlexCategoryBarChart(HttpSession session) throws Exception {
		double [][]data=new double[][]{{550,660,770,880},{660,550,770,880},{770,550,660,880},{880,550,660,770}};
		String [] rowKeys={"ƻ��","Banana","Orange","PineApple"};
		String [] columnKeys={"����","ï��","տ��","�Ƹ�"};
		CategoryDataset dataset = DatasetUtils.createCategoryDataset(rowKeys, columnKeys, data);
		//���������������
		StandardChartTheme standardChartTheme = new StandardChartTheme("CN");
        standardChartTheme.setExtraLargeFont(new Font("����", Font.BOLD, 20));
        standardChartTheme.setRegularFont(new Font("����", Font.PLAIN, 15));
        standardChartTheme.setLargeFont(new Font("����", Font.PLAIN, 15));
        ChartFactory.setChartTheme(standardChartTheme);
        
		JFreeChart chart=ChartFactory.createBarChart("ˮ������ͳ��ͼ", "ˮ��", "����", dataset,
				PlotOrientation.VERTICAL, true, true, true);
		String fileName=ServletUtilities.saveChartAsPNG(chart, 700, 500, null,session);
		return fileName;
	}
	
	/**
	 * �Զ������ʾ���������ͼ
	 * @param session
	 * @return
	 * @throws Exception
	 */
	public static  String genCustomFlexCategoryBarChart(HttpSession session) throws Exception {
		double [][]data=new double[][]{{550,660,770,880},{660,550,770,880},{770,550,660,880},{880,550,660,770}};
		String [] rowKeys={"ƻ��","Banana","Orange","PineApple"};
		String [] columnKeys={"����","ï��","տ��","�Ƹ�"};
		CategoryDataset dataset = DatasetUtils.createCategoryDataset(rowKeys, columnKeys, data);
		//���������������
		StandardChartTheme standardChartTheme = new StandardChartTheme("CN");
        standardChartTheme.setExtraLargeFont(new Font("����", Font.BOLD, 20));
        standardChartTheme.setRegularFont(new Font("����", Font.PLAIN, 15));
        standardChartTheme.setLargeFont(new Font("����", Font.PLAIN, 15));
        ChartFactory.setChartTheme(standardChartTheme);
        
		JFreeChart chart=ChartFactory.createBarChart("ˮ������ͳ��ͼ", "ˮ��", "����", dataset,
				PlotOrientation.VERTICAL, true, true, true);
		
		CategoryPlot plot = chart.getCategoryPlot();
		plot.setBackgroundPaint(Color.white); 	//�������񱳾���ɫ
		plot.setDomainGridlinePaint(Color.blue); 	//��������������ɫ
		plot.setRangeGridlinePaint(Color.pink);  	//����������ߵ���ɫ
		
		//��ʾÿ��������ֵ�����޸ĸ���ֵ����������
		BarRenderer barRenderer = new BarRenderer();
		barRenderer.setDefaultItemLabelGenerator(new StandardCategoryItemLabelGenerator());
		barRenderer.setDefaultItemLabelsVisible(true);
		
		barRenderer.setDefaultPositiveItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.OUTSIDE12, TextAnchor.BASELINE_LEFT));
		barRenderer.setItemLabelAnchorOffset(10D);
		
		//����ƽ����֮��ľ���
		barRenderer.setItemMargin(0.2);
		
		plot.setRenderer(barRenderer);
		
		String fileName=ServletUtilities.saveChartAsPNG(chart, 700, 500, null,session);
		return fileName;
	}
}
