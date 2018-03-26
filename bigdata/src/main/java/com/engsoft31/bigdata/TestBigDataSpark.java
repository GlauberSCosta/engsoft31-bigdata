package com.engsoft31.bigdata;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

public class TestBigDataSpark {

	public static void main(String[] args) {
		
//		SparkConf conf = new SparkConf().setMaster("local").setAppName("Buscar horário" );
//		JavaSparkContext ctx = new JavaSparkContext(conf);
//		JavaRDD<String> linhas = ctx.textFile("/home/bigdata/Projetos/workspace_fifa/bigdata/complete.csv");
		
//		linhas.foreach(linha -> linha.split(","));
//		
//		linhas.map(linha ->linha.split(","));
//		
//		System.out.println(	linhas.take(10).toArray());
//		
		
		SparkSession spark = SparkSession
				  .builder().master("local")
				  .appName("teste")
				  .getOrCreate();
		Dataset<Row> df = spark.read().csv("/home/bigdata/Projetos/workspace_fifa/bigdata/complete.csv");
		df.show();
	}

	

}
