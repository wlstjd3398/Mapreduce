package sub1;

import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

/*
 * ��¥ : 2021/06/21 
 * �̸� : ��ö��
 * ���� : MapReduce �ܾ� ī��Ʈ �ǽ�
 */

// map ������ �����ϴ� Ŭ����
public class WordCountMapper extends Mapper<LongWritable, Text, Text, IntWritable>{

	@Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, IntWritable>.Context context)
	
			throws IOException, InterruptedException {
		
		StringTokenizer st = new StringTokenizer(value.toString());
		
		while(st.hasMoreTokens()) {
			
			String word = st.nextToken();
			
			Text txt = new Text(word);
			IntWritable val = new IntWritable(1);
			
			context.write(txt, val);
		}
	}
	
}
