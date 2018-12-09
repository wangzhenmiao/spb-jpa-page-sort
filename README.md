# spb-jpa-page-sort

一、PagingAndSortingRepository 接口实现分页

实现了分页和排序，接口中封装了两个函数

二、CrudRepository 接口实现增删改查 Crud 操作

三、数据库的操作见sql.txt

四、程序启动后，访问

http://localhost:8080/article/sort

http://localhost:8080/article/pager?pageIndex=1

可以看到id是降序排列，分页的时候，只显示几个id的数据

五、bean的注解

1、类注解

@Entity
@Table(name="tb_article")

对应bean到数据库表 tb_article

2、id属性的注解

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
六、repo层，访问数据库的封装

1、实现接口，既可调用，不需要代码实现：PagingAndSortingRepository

    public interface ArticleRepository extends PagingAndSortingRepository<Article, Integer> {

}

七、service层

    @Service
    public class ArticleService {

    // 注入数据访问层接口对象
    @Resource
    private ArticleRepository articleRepository;

    public Iterable<Article> findAllSort(Sort sort) {
        return articleRepository.findAll(sort);
    }

    public Page<Article> findAll(Pageable page) {
        return articleRepository.findAll(page);
    }
}

1、@Service的类注解

2、@Resource ，每个spb的层，都会引入上一层对象的注入

3、实现对下一层的方法，方法中调用上一层接口的方法

八、排序的实现在controller中

通过 引入 import org.springframework.data.domain.Sort; 实现

     // 指定排序参数对象：根据id，进行降序查询
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        
九、分页的实现，在controller中

通过引入： import org.springframework.data.domain.Pageable;

    Pageable page = PageRequest.of(pageIndex - 1, 2, sort);
    
十、Iterable

十一、数据库有关sql.txt，在resource目录下

1、创建库，创建表，插入数据

