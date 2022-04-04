defmodule MyModule do
    import IO, only: [puts: 1]
    import Kernel, except: [inspect: 1]

    def hello_world do
        inspect(MyModule.Math.sum(2, 2))
    end

    def inspect(param) do
        puts("Starting inspection...")
        puts(param)
        puts("Finishing inspection...")
    end
end