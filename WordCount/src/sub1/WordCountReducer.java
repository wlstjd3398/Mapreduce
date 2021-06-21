package sub1;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

/*
 * 날짜 : 2021/06/21 
 * 이름 : 김철학
 * 내용 : MapReduce 단어 카운트 실습
 */

// Reduce 연산을 수행하는 클래스
public class WordCountReducer extends Reducer<Text, IntWritable, Text, IntWritable> {

	@Override
	protected void reduce(Text key, Iterable<IntWritable> values,
			Reducer<Text, IntWritable, Text, IntWritable>.Context context) throws IOException, InterruptedException {
	
		int sum = 0;
		
		for(IntWritable val : values) {
			sum += val.get();
		}
		
		IntWritable result = new IntWritable(sum);
		context.write(key, result);
		
	}
	
	
}
