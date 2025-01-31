package org.eternity.food.shop.adapter.out;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.eternity.food.generic.money.domain.Money;

import javax.persistence.*;

@Entity
@Table(name = "OPTION_SPECS")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OptionSpecificationJpaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "OPTION_SPEC_ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "PRICE")
    private Money price;

    @Builder
    OptionSpecificationJpaEntity(Long id, String name, Money price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}
