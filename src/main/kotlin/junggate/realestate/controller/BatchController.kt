package junggate.realestate.controller

import org.springframework.batch.core.Job
import org.springframework.batch.core.JobParametersBuilder
import org.springframework.batch.core.launch.JobLauncher
import org.springframework.batch.core.repository.JobRepository

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
class BatchController{
    @Autowired
    lateinit var jobRepository: JobRepository

    @Autowired
    lateinit var jobLauncher: JobLauncher

    @Autowired
    lateinit var job: Job

    @RequestMapping("startbatch")
    fun startBatch() : String{
        var jobParameterBuilder = JobParametersBuilder()
        jobParameterBuilder.addDate("date", Date())

        var jobExecution = jobLauncher.run(job, jobParameterBuilder.toJobParameters() )
        jobRepository.update(jobExecution)

        val resultString = "{\"result\":\"launched\"}"
        return resultString
    }


}