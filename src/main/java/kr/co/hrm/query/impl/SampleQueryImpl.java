package kr.co.hrm.query.impl;

import kr.co.hrm.entity.Sample;
import kr.co.hrm.query.SampleQuery;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

@Slf4j
@NoArgsConstructor
public class SampleQueryImpl implements SampleQuery {

    public final static String GET_SAMPLE_BY_SAMPLE_COL_LIKE = """
                SELECT 
                       *
                FROM
                    Sample
                WHERE
                    sampleCol LIKE %:sampleCol%
            """;
}
