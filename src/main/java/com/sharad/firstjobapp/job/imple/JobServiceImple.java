package com.sharad.firstjobapp.job.imple;

import com.sharad.firstjobapp.job.Job;
import com.sharad.firstjobapp.job.JobRepository;
import com.sharad.firstjobapp.job.JobService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobServiceImple implements JobService {

//    private List<Job> jobs = new ArrayList<>();

    JobRepository jobRepository;

    private long nextId = 1L;

    public JobServiceImple(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Override
    public List<Job> findAll() {
        // return jobs;
        return jobRepository.findAll();
    }

    @Override
    public void createJob(Job job) {
        job.setId(nextId++);
        // jobs.add(job);
        jobRepository.save(job);
    }

    @Override
    public Job getJobByID(Long id) {
//        for (Job job :
//                jobs) {
//            if (job.getId().equals(id)) {
//                return job;
//            }
//        }
        return jobRepository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteById(Long id) {
//        Iterator<Job> iterator = jobs.iterator();
//
//        while (iterator.hasNext()) {
//            Job job = iterator.next();
//
//            if (job.getId().equals(id)) {
//                iterator.remove();
//                return true;
//            }
//        }

        try {
            jobRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean updateJob(Long id, Job updatedJob) {

        Optional<Job> jobOptional = jobRepository.findById(id);

//        for (Job job : jobs) {
//            if (job.getId().equals(id)) {
            if (jobOptional.isPresent()) {
                Job job = jobOptional.get();
                job.setTitle(updatedJob.getTitle());
                job.setDescription(updatedJob.getDescription());
                job.setMinSalary(updatedJob.getMinSalary());
                job.setMaxSalary(updatedJob.getMaxSalary());
                job.setLocation(updatedJob.getLocation());
                jobRepository.save(job);
                return true;
            }
//        }
        return false;
    }
}
















