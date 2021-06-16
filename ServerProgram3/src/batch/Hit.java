package batch;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import dao.BoardDAO;
import dto.ReplyDTO;

public class Hit implements Job {

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		
		List<ReplyDTO> top = BoardDAO.getInstance().();
		
			System.out.println(					
					"제목 :" + top.get().getTitle();
					"내용 :" + top.get().getContent();
					"조회수 :" + top.get().getHit();
					);
			
		} 
		
	}
	
