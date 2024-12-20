<script lang="ts">
    import type {QuestionPOJO} from "./question";
</script>

<main>
    {#await fetch('http://localhost:8080/api/question')}
        <p>fetching question...</p>
    {:then question}
        {#await question.json()}
            ...
        {:then question}
            <div
                    class="flex flex-col space-y-8 border rounded justify-center items-center p-4 w-fit">
                <div class="text-4xl">
                    {question.question}
                </div>
                <div class="text-2xl border-b-2 w-full">
                    {#each question.answers as answer}
                        <div>
                            - {answer}
                        </div>
                    {/each}
                </div>
                <div class="font-extrabold self-start">
                    correct: {question.correctAnswer}
                </div>
            </div>

        {/await}
    {:catch error}
        <p>failed to make request: {error}</p>
    {/await}

</main>