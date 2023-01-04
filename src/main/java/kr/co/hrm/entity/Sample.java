package kr.co.hrm.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Sample {

    @Id
    private String id;

    private String sampleCol;

    @Builder
    public Sample(String id, String sampleCol) {
        this.id = id;
        this.sampleCol = sampleCol;
    }
}
