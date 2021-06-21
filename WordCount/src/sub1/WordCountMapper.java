package sub1;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

/*
 * 날짜 : 2021/06/21 
 * 이름 : 김철학
 * 내용 : MapReduce 단어 카운트 실습
 */

// map 연산을 수행하는 클래스
public class WordCountMapper extends Mapper<LongWritable, Text, Text, IntWritable>{

}
