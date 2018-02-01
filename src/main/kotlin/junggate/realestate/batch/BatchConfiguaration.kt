package junggate.realestate.batch

import com.rometools.rome.feed.synd.SyndFeed
import org.springframework.batch.core.Job
import org.springframework.batch.core.Step
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory
import org.springframework.batch.core.launch.support.RunIdIncrementer
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
@EnableBatchProcessing

class BatchConfiguration{

    @Autowired
    lateinit private var steps: StepBuilderFactory

    @Autowired
    lateinit private var reader: ItemReader

    @Autowired
    lateinit private var processor: ItemProcessor

    @Autowired
    lateinit private var writer: ItemWriter

    @Bean
    fun job(jobs: JobBuilderFactory, step_rss: Step): Job? {
        var job = jobs.get("job_rss")
                .incrementer(RunIdIncrementer())
                .start(step_rss)
                .build()

        println("isRestartable ${job.isRestartable}")
        return job
    }

    @Bean(name = arrayOf("step_rss"))
    fun step1(): Step {
//        return steps.get("step_rss")
//                .tasklet(Tasklet { stepContirubution, chunkContext ->
//                    RepeatStatus.CONTINUABLE
//                }).build()
        return steps.get("step_rss")
                .chunk<String, SyndFeed>(5)
                .reader(reader)
                .processor(processor)
                .writer(writer)
                .build()
    }

}