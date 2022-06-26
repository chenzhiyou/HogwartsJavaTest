package com.hogwarts.junit5Basics.self;

import com.hogwarts.ceshiren.SumData;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.aggregator.ArgumentsAggregationException;
import org.junit.jupiter.params.aggregator.ArgumentsAggregator;

import java.util.List;

public class ListAggregator implements ArgumentsAggregator {
    @Override
    public Object aggregateArguments(ArgumentsAccessor accessor,
                                     ParameterContext context) throws ArgumentsAggregationException {
        /**
         * list --- 实体类对象SumData
         *
         */
        Boolean aBoolean = accessor.getBoolean(0);
        Integer integer = accessor.getInteger(2);
        List<Integer> list = (List<Integer>)accessor.get(1);

        SumData sumData = new SumData(aBoolean, list, integer);
        return sumData;
    }
}
