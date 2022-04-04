defmodule MyModule.Calendar do
    def week_day_abreviation(week_day) do
        case week_day do
            :Monday -> "Mon"
            :Tuesday -> "Tue"
            :Wednesday -> "Wed"
            :Thursday -> "Thu"
            :Friday -> "Fri"
            :Saturday -> "Sat"
            :Sunday -> "Sun"
            _ -> "Invalid week day"
        end
    end

    def week_day_abreviation2(week_day) do
        cond do
            week_day == :Monday -> "Mon"
            week_day == :Tuesday -> "Tue"
            week_day == :Wednesday -> "Wed"
            week_day == :Thursday -> "Thu"
            week_day == :Friday -> "Fri"
            week_day == :Saturday -> "Sat"
            week_day == :Sunday -> "Sun"
            true -> "Invalid week day"
        end
    end

    def week_day_abreviation3(:Monday), do: "Mon"
    def week_day_abreviation3(:Tuesday), do: "Tue"
    def week_day_abreviation3(:Wednesday), do: "Wed"
    def week_day_abreviation3(:Thursday), do: "Thu"
    def week_day_abreviation3(:Friday), do: "Fri"
    def week_day_abreviation3(:Saturday), do: "Sat"
    def week_day_abreviation3(:Sunday), do: "Sun"
    def week_day_abreviation3(_), do: "Invalid week day"
end