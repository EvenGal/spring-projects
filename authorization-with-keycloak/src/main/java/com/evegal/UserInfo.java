package com.evegal;

import java.util.List;

public record UserInfo(
        String name,
        List<String> roles
) {
}
