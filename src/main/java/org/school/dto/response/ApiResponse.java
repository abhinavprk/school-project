package org.school.dto.response;

import java.util.Set;

public record ApiResponse <T>(T data, Set<ApiError> errors){
}
