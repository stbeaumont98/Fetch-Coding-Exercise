
Code built and tested in: [Android Studio Meerkat | 2024.3.1 Patch 2](https://androidstudio.googleblog.com/2025/04/android-studio-meerkat-202431-patch-2.html)

Sorting by "name" in the code produces results in non-numerical order. For example, a list might appear in the following order:

- Item 1
- Item 101
- Item 12
- Item 2
- Item 291
- Item 3
- Item 31

Since the number in the name corresponds to its id, I've opted to sort by id in the code; however, it's probably safe to assume that that won't be the case in a real-world scenario, and ```it.id``` on [line 45 of MainScreen.kt](https://github.com/stbeaumont98/Fetch-Coding-Exercise/blob/79c6da07df4a4fe1c4dc9411a41d515d9b4f5bca/app/src/main/java/com/example/fetchexercise/ui/main/MainScreen.kt#L45) can be changed to ```it.name``` for alphabetical sorting.

As far as I can tell from my research, you would need to create a custom comparator to properly handle sorting both letters and numbers in the string.
