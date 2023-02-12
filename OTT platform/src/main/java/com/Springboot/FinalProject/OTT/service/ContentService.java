package com.Springboot.FinalProject.OTT.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Springboot.FinalProject.OTT.dto.ContentDto;
import com.Springboot.FinalProject.OTT.dto.PaymentDto;
import com.Springboot.FinalProject.OTT.entity.Content;
import com.Springboot.FinalProject.OTT.entity.Payment;
import com.Springboot.FinalProject.OTT.repository.ContentRepository;

import jakarta.transaction.Transactional;

@Service
public class ContentService {

	@Autowired
	private ContentRepository contentrepository;
	
	private ModelMapper modelMapper = new ModelMapper();
	
	public Content saveContent(ContentDto contentDto) {
		// Content content1 = new Content();
		//Content1.setTitle(contentDto.getTitle());
		//content1.setCountry(contentDto.getCountry());
		Content content1 = modelMapper.map(contentDto,Content.class);
		
		Content save = contentrepository.save(content1);
		return save;
	}

	
	
	
	@Transactional
	public int deleteContentByContentId(long contentId) {
		return  contentrepository.deleteByContentid(contentId);
	}

	public Content findbyContentId(long contentId) {
		
		return (Content)contentrepository.findById(contentId).get();
	}

	public List<Content> findAllContents() {
		return contentrepository.findAll();
	}
	
	public Content editContent(ContentDto contentDto, long id) {
		Content content = contentrepository.findById(id).get();
		content.setTitle(contentDto.getTitle());
		content.setCountry(contentDto.getCountry());
			return contentrepository.save(content);
	
	}
}
