package kr.co.hrm.repository;

import kr.co.hrm.entity.Sample;
import kr.co.hrm.query.impl.SampleQueryImpl;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SampleRepository extends CrudRepository<kr.co.hrm.entity.Sample, String> {

    @Query(value = SampleQueryImpl.GET_SAMPLE_BY_SAMPLE_COL_LIKE, nativeQuery = true)
    Iterable<Sample> findBySampleColLikes(String sampleCol);

}
