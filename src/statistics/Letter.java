package statistics;

import java.text.DecimalFormat;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileNotFoundException;

public class Letter {
	private void HandleLetter(File file)throws IOException,FileNotFoundException{
        DecimalFormat df = new DecimalFormat("#0.00");
        if(file.length()>0){
            int[] iNum=new int[26];
            FileReader fr=new FileReader(file);
            BufferedReader br=new BufferedReader(fr);
            int i,count=0;
            while((i=br.read())!=-1){
                i-='a';
                if(i>-1&&i<26) iNum[i]++;
            }
            br.close();
            fr.close();
            for(i=0;i<26;i++) count+=iNum[i];//总字母
            System.out.println("字母总数："+count);
            for(i=0;i<26;i++){//打印
                if(iNum[i]!=0)
                    System.out.println((char)(i+(int)'a')+"有"+iNum[i]+"个，占"+(df.format(iNum[i]*100/(double)count)+"%"));
            }
        }
        else
            System.out.println("文件不存在或者无数据，请确认文件！");
    }
    public static void main(String[] args)throws IOException,FileNotFoundException{
        Letter le=new Letter();
        File file=new File(".txt");//文件路径，记得加后缀
        le.HandleLetter(file);
    }
}
