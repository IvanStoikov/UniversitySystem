
Java Tasks Technical University Sofia - Example Exam

Да се реализира сървър за студентска информационна система подобна на уисс.

Системата има 3 вида потребители - администратор, студент и преподавател. Всичките достъпват системата чрез потребителско име и парола.

Създайте абстрактен клас User с полета username и password и метод getUserTуре, който ще връща изброим тип със съответния вид потребител. [5т.]

Създайте трите типа потребителски класове - Admin, Student u Teacher. Те наследяват User. Student да съдържа и списък с Grade - клас за оценки с полета за предмет, номер на семестър и оценка. [5т.]

При достъпване на системата, клиентът трябва да въведе потребителско име и парола за вход. След успешен вход всеки потребител има различни възможности за работа: Администраторите могат да създават нови потребителски акаунти. При създаване на акаунт има определени изисквания за формата на потребителското име и паролата: Студент: Факултетен номер - 9 цифри, ЕГН - 10 цифри [5т.] Преподавател: имейл - една или повече малки букви следвани от @ tu-sofia.bg, парола - поне 5 символа [5т.] За валидация на низовете създайте регулярни изрази.

При вход на студент списъкът оценките му се сортира по номер на семестъра и името на дисциплината в азбучен ред. Списъкът се преобразува в низ, който се изпращя на клиентската програма. [10г.]

Преподавателите могат да нанасят оценки. При вход те въвеждат низ за факултетен номер и попълват полетата на Grade. Ако студент с такъв факултетен номер бъде намерен, в неговия списък с оценки се добавя новата. [10т.]

Реализирайте описаните функционалности на трите вида потребители. Сървърът трябва да може да обслужва няколко клиентски програми едновременно.[10т.] При работа със споделени ресурси да се осигури необходимата синхронизация. [10т.]


Max points: 60
Scale:
0-20 -> 2
21-31 -> 3
31-41 -> 4
41-51 -> 5
51-60 -> 6
