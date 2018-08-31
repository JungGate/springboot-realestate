package junggate.realestate.batch

import com.rometools.rome.feed.synd.SyndFeed
import org.springframework.batch.core.*
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory
import org.springframework.batch.core.launch.JobLauncher
import org.springframework.batch.core.launch.support.RunIdIncrementer
import org.springframework.batch.core.launch.support.SimpleJobLauncher
import org.springframework.batch.core.repository.JobRepository
import org.springframework.batch.core.repository.support.MapJobRepositoryFactoryBean
import org.springframework.batch.support.transaction.ResourcelessTransactionManager
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.core.task.SimpleAsyncTaskExecutor
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.transaction.PlatformTransactionManager

@Configuration
@EnableBatchProcessing
class BatchConfiguration{
    @Autowired
    lateinit private var jobBuilderFactory: JobBuilderFactory

    @Autowired
    lateinit private var steps: StepBuilderFactory

    @Autowired
    lateinit private var reader: ItemReader

    @Autowired
    lateinit private var processor: ItemProcessor

    @Autowired
    lateinit private var writer: ItemWriter

    @Autowired
    lateinit private var batch: RssBatch

    @Bean
    fun job(): Job? {
        var job = jobBuilderFactory.get("job_rss")
                .incrementer(RunIdIncrementer())
                .start(rssStep())
                .build()
        return job
    }

    @Bean
    fun rssStep(): Step {
        return steps.get("step_rss")
                .chunk<String, SyndFeed>(5)
                .reader(reader)
                .processor(processor)
                .writer(writer)
                .build()
    }
    @Scheduled(fixedDelay = 10000)//처음 시작할때 한번....너무해..
    fun schedule1(){
        batch.run()
    }
}