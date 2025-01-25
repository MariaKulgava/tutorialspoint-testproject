package enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Menu {
    HOME("Home"),
    ONLINE_COMPILERS("Online Compilers"),
    JOBS("Jobs");

    private final String name;
}
