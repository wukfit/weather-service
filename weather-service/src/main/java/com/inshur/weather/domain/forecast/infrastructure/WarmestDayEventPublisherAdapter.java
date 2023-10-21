package com.inshur.weather.domain.forecast.infrastructure;

import com.inshur.weather.domain.forecast.core.model.WarmestDayFoundEvent;
import com.inshur.weather.domain.forecast.core.model.WarmestDayRequestedEvent;
import com.inshur.weather.domain.forecast.core.ports.outgoing.WarmestDayEventPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class WarmestDayEventPublisherAdapter implements WarmestDayEventPublisher {

    private final ApplicationEventPublisher eventPublisher;

    @Autowired
    public WarmestDayEventPublisherAdapter(ApplicationEventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }


    @Override
    public void publish(WarmestDayFoundEvent event) {
        eventPublisher.publishEvent(event);
    }

    @Override
    public void publish(WarmestDayRequestedEvent event) {
        eventPublisher.publishEvent(event);
    }
}
