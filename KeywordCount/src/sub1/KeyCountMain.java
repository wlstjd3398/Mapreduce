package sub1;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;

/*
 * 날짜 : 2021/06/21 
 * 이름 : 김철학
 * 내용 : MapReduce 단어 카운트 실습
 */

public class KeyCountMain {
	public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
		Configuration conf = new Configuration();
				Job job = new Job(conf, "KeyWordCount");
				
				job.setJarByClass(KeyCountMain.class);
				job.setMapperClass(KeyCountMapper.class);
				job.setReducerClass(KeyCountReducer.class);
				
				job.setInputFormatClass(TextInputFormat.class);
				job.setOutputFormatClass(TextOutputFormat.class);
				
				job.setOutputKeyClass(Text.class);
				job.setOutputValueClass(IntWritable.class);
				
				FileInputFormat.addInputPath(job,  new Path(args[0]));
				FileOutputFormat.setOutputPath(job,  new Path(args[1]));
				
				job.waitForCompletion(true);
				
				System.out.println("KeyWordCount MapReduce 종료...");
				
	}
}
