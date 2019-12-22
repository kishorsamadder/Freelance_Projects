import { Directive, ElementRef, ViewContainerRef, TemplateRef, Input } from '@angular/core';
@Directive({
  selector: '[repeater]'
})
export class RepeaterDirective {
  @Input() set repeaterOf(list) {
    this.view.clear();
    const total = list.length;
    for (let i = 0; i < total; i++) {
      const item = list[i];
      this.view.createEmbeddedView(this.template, {
        $implicit: {
          $item: item,
          $index: i + 1,
          $displayName:  `${item.jobId} ${item.jobCategory}`
        },
        $total: total
      });
    }
  }
  constructor(
    private el: ElementRef,
    private view: ViewContainerRef,
    private template: TemplateRef<any>
  ) {
    console.log (el.nativeElement, template);
  }

  // ngAfterViewInit() {
  //   this.view.createEmbeddedView(this.template);
  // }
}
