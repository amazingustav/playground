defmodule MyModule.Loop do
    def multiplication_table(_, 11), do: nil

    def multiplication_table(multiplier) do
        multiplication_table(multiplier, 1)
    end

    def multiplication_table(product1, product2) do
        IO.puts("#{product1} x #{product2} = #{product1 * product2}")
        multiplication_table(product1, product2 + 1)
    end
end