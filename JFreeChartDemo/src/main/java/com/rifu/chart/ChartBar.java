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
 * 柱形图
 * @author Lifu
 *
 */
public class ChartBar {
	public static  String genBarChart(HttpSession session) throws Exception {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		dataset.addValue(510, "深圳", "苹果");
		dataset.addValue(320, "深圳", "香蕉");
		dataset.addValue(580, "深圳", "橘子");
		dataset.addValue(390, "深圳", "梨子");
		StandardChartTheme standardChartTheme = new StandardChartTheme("CN");
        standardChartTheme.setExtraLargeFont(new Font("隶书", Font.BOLD, 20));
        standardChartTheme.setRegularFont(new Font("宋书", Font.PLAIN, 15));
        standardChartTheme.setLargeFont(new Font("宋书", Font.PLAIN, 15));
        ChartFactory.setChartTheme(standardChartTheme);
		JFreeChart chart=ChartFactory.createBarChart("水果销售统计图", "水果", "销售", dataset,
				PlotOrientation.VERTICAL, true, true, true);
		String fileName=ServletUtilities.saveChartAsPNG(chart, 700, 500, null,session);
		return fileName;
	}
	
	public static  String genCategoryBarChart(HttpSession session) throws Exception {
		double [][]data=new double[][]{{550},{660},{770},{880}};
		String [] rowKeys={"苹果","Banana","Orange","PineApple"};
		String [] columnKeys={"深圳"};
		CategoryDataset dataset = DatasetUtils.createCategoryDataset(rowKeys, columnKeys, data);
		//解决中文乱码问题
		StandardChartTheme standardChartTheme = new StandardChartTheme("CN");
        standardChartTheme.setExtraLargeFont(new Font("隶书", Font.BOLD, 20));
        standardChartTheme.setRegularFont(new Font("宋书", Font.PLAIN, 15));
        standardChartTheme.setLargeFont(new Font("宋书", Font.PLAIN, 15));
        ChartFactory.setChartTheme(standardChartTheme);
        
		JFreeChart chart=ChartFactory.createBarChart("水果销售统计图", "水果", "销售", dataset,
				PlotOrientation.VERTICAL, true, true, true);
		String fileName=ServletUtilities.saveChartAsPNG(chart, 700, 500, null,session);
		return fileName;
	}
	
	
	public static  String genFlexCategoryBarChart(HttpSession session) throws Exception {
		double [][]data=new double[][]{{550,660,770,880},{660,550,770,880},{770,550,660,880},{880,550,660,770}};
		String [] rowKeys={"苹果","Banana","Orange","PineApple"};
		String [] columnKeys={"深圳","茂名","湛江","云浮"};
		CategoryDataset dataset = DatasetUtils.createCategoryDataset(rowKeys, columnKeys, data);
		//解决中文乱码问题
		StandardChartTheme standardChartTheme = new StandardChartTheme("CN");
        standardChartTheme.setExtraLargeFont(new Font("隶书", Font.BOLD, 20));
        standardChartTheme.setRegularFont(new Font("宋书", Font.PLAIN, 15));
        standardChartTheme.setLargeFont(new Font("宋书", Font.PLAIN, 15));
        ChartFactory.setChartTheme(standardChartTheme);
        
		JFreeChart chart=ChartFactory.createBarChart("水果销售统计图", "水果", "销售", dataset,
				PlotOrientation.VERTICAL, true, true, true);
		String fileName=ServletUtilities.saveChartAsPNG(chart, 700, 500, null,session);
		return fileName;
	}
	
	/**
	 * 自定义的显示分类的柱形图
	 * @param session
	 * @return
	 * @throws Exception
	 */
	public static  String genCustomFlexCategoryBarChart(HttpSession session) throws Exception {
		double [][]data=new double[][]{{550,660,770,880},{660,550,770,880},{770,550,660,880},{880,550,660,770}};
		String [] rowKeys={"苹果","Banana","Orange","PineApple"};
		String [] columnKeys={"深圳","茂名","湛江","云浮"};
		CategoryDataset dataset = DatasetUtils.createCategoryDataset(rowKeys, columnKeys, data);
		//解决中文乱码问题
		StandardChartTheme standardChartTheme = new StandardChartTheme("CN");
        standardChartTheme.setExtraLargeFont(new Font("隶书", Font.BOLD, 20));
        standardChartTheme.setRegularFont(new Font("宋书", Font.PLAIN, 15));
        standardChartTheme.setLargeFont(new Font("宋书", Font.PLAIN, 15));
        ChartFactory.setChartTheme(standardChartTheme);
        
		JFreeChart chart=ChartFactory.createBarChart("水果销售统计图", "水果", "销售", dataset,
				PlotOrientation.VERTICAL, true, true, true);
		
		CategoryPlot plot = chart.getCategoryPlot();
		plot.setBackgroundPaint(Color.white); 	//设置网格背景颜色
		plot.setDomainGridlinePaint(Color.blue); 	//设置网格竖线颜色
		plot.setRangeGridlinePaint(Color.pink);  	//设置网格横线的颜色
		
		//显示每个柱的数值，并修改该数值的字体属性
		BarRenderer barRenderer = new BarRenderer();
		barRenderer.setDefaultItemLabelGenerator(new StandardCategoryItemLabelGenerator());
		barRenderer.setDefaultItemLabelsVisible(true);
		
		barRenderer.setDefaultPositiveItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.OUTSIDE12, TextAnchor.BASELINE_LEFT));
		barRenderer.setItemLabelAnchorOffset(10D);
		
		//设置平行柱之间的距离
		barRenderer.setItemMargin(0.2);
		
		plot.setRenderer(barRenderer);
		
		String fileName=ServletUtilities.saveChartAsPNG(chart, 700, 500, null,session);
		return fileName;
	}
}
