package kr.co.hrm.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SampleRepository extends CrudRepository<kr.co.hrm.entity.Sample, String> {

}
