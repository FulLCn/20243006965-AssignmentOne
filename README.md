# CampusLife — COMPX202 Assignment One

A small Android companion app for University of Waikato students, built for
COMPX202/Y05853 Assignment One. The main screen shows a banner and four topic buttons;
each button opens a detail screen describing that service area.

## How the assignment parts map to the code

| Part | Where it lives |
| --- | --- |
| A — project + Git | The Gradle project itself; one commit and one push per part |
| B — Android XML | `res/layout/activity_main.xml`: banner plus a 2 x 2 grid, built only from `LinearLayout` weights |
| C — resources | `res/values/colors.xml`, `res/drawable/btn_selector.xml`, `CampusLife` in `strings.xml`, green adaptive launcher icon |
| D — orientation | `res/layout-land/activity_main.xml`: the same layout with the four buttons in a single row |
| E — onClick events | `MainActivity`: one listener per `ImageButton`, each showing a Toast |
| F — new activity | `DetailActivity` and `res/layout/activity_detail.xml`, declared in `AndroidManifest.xml` |
| G — Intent | `MainActivity.openDetail()` passes `EXTRA_TOPIC_INDEX` through an explicit Intent |
| H — UI from Java | `res/values/arrays.xml` plus `DetailActivity.onCreate()`, which indexes the arrays with the identifier |
| I — code quality | Javadoc on every class and method, section comments in the XML, and this README |

## Key files

| File | Purpose |
| --- | --- |
| `res/layout/activity_main.xml` | Portrait main screen |
| `res/layout-land/activity_main.xml` | Landscape main screen |
| `res/layout/activity_detail.xml` | Detail screen: image, title, scrollable body text |
| `res/values/arrays.xml` | Dummy data: titles, body text and image names for the four topics |
| `res/values/colors.xml` | Green `#1B5E20`, light green `#66BB6A`, black and white |
| `res/drawable/btn_selector.xml` | Green at rest, light green while pressed |
| `MainActivity.java` | Wires the buttons and starts the detail screen |
| `DetailActivity.java` | Reads the topic index and fills the UI from `arrays.xml` |

## Design notes

- **Responsiveness.** Every size in both main layouts is expressed with `layout_weight`;
  the only fixed value is the banner title at `40sp`, which the specification allows.
- **No if statements or switch cases.** The topic index that arrives in the Intent is used
  directly as the array index, so the detail screen contains no branching logic.
- **Stable identifiers.** Each topic has a constant in `MainActivity` (`TOPIC_FACILITIES` etc.)
  that matches its position in all three arrays in `arrays.xml`.

## Icons

The four topic icons in `res/drawable` are white vector placeholders so the project builds and
runs on its own. To use the supplied artwork, replace them with same-named PNG files; the
resource names used by the layouts and by `arrays.xml` stay the same.
