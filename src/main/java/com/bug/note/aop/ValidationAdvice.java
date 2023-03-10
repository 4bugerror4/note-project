package com.bug.note.aop;

import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import com.bug.note.handler.CustomApiException;

@Component
@Aspect
public class ValidationAdvice {

	@Around("execution(* com.bug.note.controller.api.*Controller.*(..))")
	public Object apiAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

		Object[] args = proceedingJoinPoint.getArgs();

		for (Object arg : args) {
			if (arg instanceof BindingResult) {
				BindingResult bindingResult = (BindingResult) arg;
				
				if (bindingResult.hasErrors()) {
					Map<String, String> errorMap = new HashMap<>();
					
					for (FieldError error : bindingResult.getFieldErrors()) {
						errorMap.put(error.getField(), error.getDefaultMessage());
					}
					
					throw new CustomApiException("유효성 검사 실패", errorMap);
				}
			}
		}

		return proceedingJoinPoint.proceed();
	}

}

