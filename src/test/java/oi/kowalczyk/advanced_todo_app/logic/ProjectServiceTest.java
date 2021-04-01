package oi.kowalczyk.advanced_todo_app.logic;

import oi.kowalczyk.advanced_todo_app.TaskConfigurationProperties;
import oi.kowalczyk.advanced_todo_app.model.TaskGroupRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ProjectServiceTest {

    @Test
    @DisplayName("should throw IllegalStateException when configured to allow just 1 group and the other undone group exists")
    void createGroup_noMultipleGroupsConfig_And_undoneGroup_throwsIllegalStateException() {
        // given
        var mockGroupRepository = mock(TaskGroupRepository.class);
        when(mockGroupRepository.existsByDoneIsFalseAndProject_Id(anyInt())).thenReturn(true);
        // and
        var mockTemplate = mock(TaskConfigurationProperties.Template.class);
        when(mockTemplate.isAllowMultipleTasks()).thenReturn(false);
        // and
        var mockConfig = mock(TaskConfigurationProperties.class);
        when(mockConfig.getTemplate()).thenReturn(mockTemplate);
        // system under test
        var toTest = new ProjectService(null, mockGroupRepository, mockConfig);


        // when
        var exception = catchThrowable(() -> toTest.createGroup(LocalDateTime.now(), 0));
        // then
//        assertThatThrownBy(() -> toTest.createGroup(LocalDateTime.now(), 0)).isInstanceOf(IllegalStateException.class);
        assertThat(exception).isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("one undone group");

    }

}