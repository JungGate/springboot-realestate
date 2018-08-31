package junggate.realestate.batch

import org.springframework.batch.core.Job
import org.springframework.batch.core.JobParametersBuilder
import org.springframework.batch.core.launch.JobLauncher
import org.springframework.batch.core.launch.support.SimpleJobLauncher
import org.springframework.batch.core.repository.JobRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service
import java.util.*

@Service
class RssBatch(){
    @Autowired
    lateinit var jobLauncher: JobLauncher

    @Autowired
    lateinit var job: Job

    fun run(){
        var jobParameterBuilder = JobParametersBuilder()
        jobParameterBuilder.addDate("date", Date())

        jobLauncher.run(job, jobParameterBuilder.toJobParameters() )
    }
}