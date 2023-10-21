package com.inshur.weather.domain.forecast.core.ports.outgoing;

import com.inshur.weather.domain.forecast.core.model.WarmestDayFoundEvent;
import com.inshur.weather.domain.forecast.core.model.WarmestDayRequestedEvent;

public interface WarmestDayEventPublisher {
    void publish(WarmestDayFoundEvent event);

    void publish(WarmestDayRequestedEvent event);
}
