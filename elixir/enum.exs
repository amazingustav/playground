defmodule MyModule.Enum do
    def first(list) do
        unless length(list) == 0 do
            hd(list)
        end
    end
end