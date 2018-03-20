package com.engsoft31.bigdata;

import java.util.List;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

public class TestBigDataSpark {
	
	
	public static void main(String[] args) {
		// configuração do Spark
        SparkConf conf = new SparkConf().setMaster("local").setAppName("BigData");
        JavaSparkContext ctx = new JavaSparkContext(conf);

        // carrega os dados dos ônibus de sp
        JavaRDD<String> linhas = ctx.textFile("/home/bigdata/Projetos/bigdata/testeOnibus.txt");

        // 	filtra os registros de ônibus pelo nome da linha
        JavaRDD<String> linhasFiltradas = linhas.filter(s -> s.contains("33441"));
        
        // 	mostra todos os ônibus filtrados
        List<String> resultados = linhasFiltradas.collect();
        for (String linha : resultados) {
              System.out.println(linha);
        }
        
        ctx.close();
	}

}
