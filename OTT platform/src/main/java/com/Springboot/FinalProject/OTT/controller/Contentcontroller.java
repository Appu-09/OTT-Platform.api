package com.Springboot.FinalProject.OTT.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Springboot.FinalProject.OTT.dto.ContentDto;
import com.Springboot.FinalProject.OTT.dto.PaymentDto;
import com.Springboot.FinalProject.OTT.entity.Content;
import com.Springboot.FinalProject.OTT.entity.Payment;
import com.Springboot.FinalProject.OTT.repository.ContentRepository;
import com.Springboot.FinalProject.OTT.service.ContentService;

@RestController
@RequestMapping("/content")
public class Contentcontroller {

	 
	    @Autowired
	    private ContentService contentService;

	    @Autowired
	    private ContentRepository contentRepository;
	    
	    @PostMapping
	    public Content saveContent(@RequestBody ContentDto contentDto) {
	    	return contentService.saveContent(contentDto);
	    }
	    
	    
	    @GetMapping
	    public List<Content>getAllContents(){
	    	return contentService.findAllContents();
	    }
	    
	    
	    @GetMapping("/{contentId}")
	   
	    public Content getContentById(@PathVariable long id) {
	    	return   contentService.findbyContentId(id);
	    }
	    @DeleteMapping("/{contentId}")
	    public int deleteContentByContentId(@PathVariable("contentid")long contentid) {
	    	return contentService.deleteContentByContentId(contentid);
	    }
	   
	    
	    @PutMapping("/content/{id}")
		   public Content updateContent(@PathVariable long id,@RequestBody ContentDto contentDto) {
			  return  contentService.editContent(contentDto,id);
		 		
	    }
}
	   
