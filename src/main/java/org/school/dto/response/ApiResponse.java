package org.school.dto.response;

import java.util.List;

public record ApiResponse <T>(T data, List<ApiError> errors){
}
