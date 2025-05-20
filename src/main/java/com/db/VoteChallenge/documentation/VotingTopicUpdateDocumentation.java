package com.db.VoteChallenge.documentation;

import io.swagger.v3.oas.annotations.media.Schema;
import org.apache.commons.lang3.StringUtils;

public interface VotingTopicUpdateDocumentation {
    String name = StringUtils.EMPTY;

    String description = StringUtils.EMPTY;

    @Schema(hidden = true)
    Boolean isActive = true;
}
