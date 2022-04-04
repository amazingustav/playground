defmodule MyModule do
    import IO, only: [puts: 1]
    import Kernel, except: [inspect: 1]

    alias MyModule.Math, as: MyMath

    def hello_world do
        inspect(MyMath.sum(2, 2))
    end

    def is_even(number) do
        require Integer
        puts("Is the number #{number} even? #{Integer.is_even(number)}")
    end

    def inspect(param) do
        puts("Starting inspection...")
        puts(param)
        puts("Finishing inspection...")
    end
end