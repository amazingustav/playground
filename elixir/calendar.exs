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
end