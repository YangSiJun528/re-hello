package dev.yangsijun.rehello.application.domain.personalInformation;

import dev.yangsijun.rehello.application.domain.enums.GraduationStatus;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
//@AllArgsConstructor 이 구현체에서 추가한 필드가 없어서 컴파일 에러 발생함
@DiscriminatorValue(GraduationStatus.Values.GED)
public class GedPersonalInformation extends AbstractPersonalInformation {
}
