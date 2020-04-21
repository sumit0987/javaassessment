package com.foodzone.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import com.foodzone.processor.MenuItemProcessor;
import com.foodzone.dto.MenuItemDto;

@Configuration
@EnableBatchProcessing
public class BatchConfig {
	@Autowired
	JobBuilderFactory jobBuilderFactory;

	@Autowired
	StepBuilderFactory stepBuilderFactory;
	
	@Bean
	public LineMapper<MenuItemDto> lineMapper() {
		DefaultLineMapper<MenuItemDto> lineMapper = new DefaultLineMapper<MenuItemDto>();
		lineMapper.setLineTokenizer(new DelimitedLineTokenizer() {
			{
				setNames(new String[] { "itemId","itemName","itemDesc","itemCost","outletId" });
			}
		});
		lineMapper.setFieldSetMapper(new BeanWrapperFieldSetMapper<MenuItemDto>() {
			{
				setTargetType(MenuItemDto.class);
			}
		});
		return lineMapper;
	}
	
	@Bean
	public FlatFileItemReader<MenuItemDto> reader() {
	    return new FlatFileItemReaderBuilder<MenuItemDto>()
		  .name("menuItemReader")		
		  .resource(new ClassPathResource("menu_item.csv"))
		  .lineMapper(lineMapper())
		  .linesToSkip(1)
		  .build(); 
	}
	
	@Bean
	public Job createCustomerJob(Step step1) {
	    return jobBuilderFactory
		  .get("createCustomerJob")
		  .incrementer(new RunIdIncrementer())
		  .start(step1)
		  .build();
	}

	@Bean
	public Step step(FlatFileItemReader<MenuItemDto> reader,MenuItemProcessor processor, ItemWriter<MenuItemDto> itemWriter) {
	    return stepBuilderFactory
		  .get("step1")
		  .<MenuItemDto, MenuItemDto>chunk(2)
		  .reader(reader)
		  .processor(processor)
		  .writer(itemWriter)
		  .build();
	}
	
	
}
