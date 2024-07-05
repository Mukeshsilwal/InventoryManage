package com.program.InventoryManagement.configuration;

import com.program.InventoryManagement.payload.OrderDto;
import com.program.InventoryManagement.payload.ProductDto;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.PathResource;

import javax.sql.DataSource;

@Configuration
@EnableBatchProcessing
@RequiredArgsConstructor
public class BatchConfig {
    private final DataSource dataSource;
    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;

    @Bean
    public FlatFileItemReader<ProductDto> reader(){
        FlatFileItemReader<ProductDto> reader=new FlatFileItemReader<>();
        reader.setResource(new PathResource("exportedProduct.csv"));
        reader.setLineMapper(getLineMapper());
        reader.setLinesToSkip(0);
        return reader;

    }
    @Bean
    public FlatFileItemReader<OrderDto> reader1(){
        FlatFileItemReader<OrderDto> reader=new FlatFileItemReader<>();
        reader.setResource(new PathResource("exportedOrder.csv"));
        reader.setLineMapper(getLineMapper1());
        reader.setLinesToSkip(0);
        return reader;

    }

    private LineMapper<ProductDto> getLineMapper() {
        DefaultLineMapper<ProductDto> lineMapper=new DefaultLineMapper<ProductDto>();
        DelimitedLineTokenizer lineTokenizer=new DelimitedLineTokenizer();
        lineTokenizer.setNames(new String[]{"productName"});
        lineTokenizer.setIncludedFields(new int[]{0});
        BeanWrapperFieldSetMapper<ProductDto> fieldSetter=new BeanWrapperFieldSetMapper<>();
        fieldSetter.setTargetType(ProductDto.class);
        lineMapper.setLineTokenizer(lineTokenizer);
        lineMapper.setFieldSetMapper(fieldSetter);
        return lineMapper;
    }
    private LineMapper<OrderDto> getLineMapper1() {
        DefaultLineMapper<OrderDto> lineMapper=new DefaultLineMapper<OrderDto>();
        DelimitedLineTokenizer lineTokenizer=new DelimitedLineTokenizer();
        lineTokenizer.setNames(new String[]{"orderName"});
        lineTokenizer.setIncludedFields(new int[]{0});
        BeanWrapperFieldSetMapper<OrderDto> fieldSetter=new BeanWrapperFieldSetMapper<>();
        fieldSetter.setTargetType(OrderDto.class);
        lineMapper.setLineTokenizer(lineTokenizer);
        lineMapper.setFieldSetMapper(fieldSetter);
        return lineMapper;
    }
    @Bean
    public ProductItemProcessor processor(){
        return new ProductItemProcessor();
    }
    @Bean
    public OrderItemProcessor processor1(){
        return new OrderItemProcessor();
    }
    @Bean
    public JdbcBatchItemWriter<ProductDto> writer(){
        JdbcBatchItemWriter<ProductDto> writer=new JdbcBatchItemWriter<>();
        writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<ProductDto>());
        writer.setSql("insert into uu(productName) values (:productName)");
        writer.setDataSource(this.dataSource);
        return writer;
    }
    @Bean
    public JdbcBatchItemWriter<OrderDto> writer1(){
        JdbcBatchItemWriter<OrderDto> writer=new JdbcBatchItemWriter<>();
        writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<OrderDto>());
        writer.setSql("insert into uuuu(orderName) values (:orderName)");
        writer.setDataSource(this.dataSource);
        return writer;
    }

//    @Bean
//    public Job importProduct1(){
//        return this.jobBuilderFactory.get("ORDER-IMPORT-JOB")
//                .incrementer(new RunIdIncrementer())
//                .flow(step2())
//                .end()
//                .build();
//    }

    @Bean
    public Step step1() {
      return  this.stepBuilderFactory.get("step1")
                .<ProductDto,ProductDto>chunk(10)
                .reader(reader())
                .processor(processor())
                .writer(writer())
                .build();
    }
    @Bean
    public Step step2() {
        return  this.stepBuilderFactory.get("step2")
                .<OrderDto,OrderDto>chunk(10)
                .reader(reader1())
                .processor(processor1())
                .writer(writer1())
                .build();
    }

}
