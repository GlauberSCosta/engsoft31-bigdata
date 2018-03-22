package com.engsoft31.bigdata;

import java.util.ArrayList;
import java.util.List;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;


public class TestBigDataSpark {
	
	
	public static void main(String[] args) {
		// configuração do Spark
//        SparkConf conf = new SparkConf().setMaster("local").setAppName("BigData");
//        JavaSparkContext ctx = new JavaSparkContext(conf);
//
//        // carrega os dados dos ônibus de sp
//        JavaRDD<String> linhas = ctx.textFile("/home/bigdata/Projetos/bigdata/testeOnibus.txt");
//
//        // 	filtra os registros de ônibus pelo nome da linha
//        JavaRDD<String> linhasFiltradas = linhas.filter(s -> s.contains("33441"));
//        
//        // 	mostra todos os ônibus filtrados
//        List<String> resultados = linhasFiltradas.collect();
//        for (String linha : resultados) {
//              System.out.println(linha);
//        }
//        
//        ctx.close();
		
		
		
		
		SparkSession spark = SparkSession.builder().appName("Fifa18").getOrCreate();
		
		Dataset<Row> df = spark.read().option("header", "true").option("delimiter","\t").csv("/home/bigdata/Projetos/bigdata/fifa18.csv");
		
		df.createOrReplaceTempView("jogadores");
		
		Dataset<Row> sqlResult = spark.sql("SELECT name, club, eur_value, eur_release_clause, overall" 
										+ " FROM jogadores");
										
		
		// comentado erro de compilação
		List<String> resultados =  new ArrayList<String>();//sqlResult.as(Strings).collectAsList();
		
		for (String linha : resultados) {
              System.out.println(linha);
        }
	}

}
