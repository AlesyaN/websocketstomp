package ru.itis.websocketstomp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MessageDTO {
    private String text;
    private Long roomId;
    private String token;
    private Long senderId;
    private String sender;
    private Date date;

    @Override
    public String toString() {
        return "MessageDTO{" +
                "text=" + text + '\'' +
                ", roomId=" + roomId +
                ", token='" + token + '\'' +
                '}';
    }
}
