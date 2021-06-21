package sub1;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

/*
 * ��¥ : 2021/06/21 
 * �̸� : ��ö��
 * ���� : MapReduce �ܾ� ī��Ʈ �ǽ�
 */

// Reduce ������ �����ϴ� Ŭ����
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
