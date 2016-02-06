package com.github.dreamhead.moco.parser.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.github.dreamhead.moco.MocoRest;
import com.github.dreamhead.moco.RestSetting;
import com.google.common.base.Function;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class RestGetSetting extends RestBaseSetting {
    private String id;

    public static Function<RestGetSetting, RestSetting> toGetSetting() {
        return new Function<RestGetSetting, RestSetting>() {
            @Override
            public RestSetting apply(final RestGetSetting setting) {
                return MocoRest.get(setting.id).response(setting.getResponseHandler());
            }
        };
    }
}